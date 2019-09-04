package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahEan;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static org.junit.Assert.assertEquals;

public class LotePanamahTest {

    private static PanamahConfig c = PanamahConfig.fromEnv("staging");

    @AfterClass
    public static void limpeza() throws Exception {
        Path lotes = Paths.get(c.getBasePath(), "lotes");
        Files.walkFileTree(lotes, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                file.toFile().delete();
                return super.visitFile(file, attrs);
            }
        });
        Thread.sleep(10);
        lotes.toFile().delete();
    }

    @Test
    public void deveFecharLoteCom500Itens() throws Exception {
        PanamahStream p = PanamahStream.init(c);
        int i = 500;
        while (i-- > 0) {
            PanamahEan ean = new PanamahEan();
            ean.setId("1");
            ean.setProdutoId("1");
            p.save(ean);
        }
        assertEquals(0, p.getTask().getLoteAtual().getOperacoes().size());
        p.flush(true);
    }

    @Test
    public void deveMoverExcedenteLote() throws Exception {
        PanamahStream p = PanamahStream.init(c);
        int i = 600;
        while (i-- > 0) {
            PanamahEan ean = new PanamahEan();
            ean.setId("1");
            ean.setProdutoId("1");
            p.save(ean);
        }
        assertEquals(100, p.getTask().getLoteAtual().getOperacoes().size());
        p.flush(true);
    }

    @Test
    public void deveriaTolerarConcorrencia() throws Exception {
        final PanamahStream p = PanamahStream.init(c);
        // java 8 codelevel disabled
//        Thread t1 = new Thread(() -> addEan(p,350))
//        Thread t2 = new Thread(() -> addEan(p,350))
        Thread t1 = new Thread() {
            public void run() {
                addEan(p, 350);
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                addEan(p, 350);
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        p.flush(true);

    }

    private void addEan(PanamahStream p, int i) {
        while (i-- > 0) {
            PanamahEan ean = new PanamahEan();
            ean.setId("1");
            ean.setProdutoId("1");
            try {
                p.save(ean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
