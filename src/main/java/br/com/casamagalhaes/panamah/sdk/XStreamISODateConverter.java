package br.com.casamagalhaes.panamah.sdk;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class XStreamISODateConverter implements Converter {

	private final DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser();
	private final DateFormat dateFormat;

	public XStreamISODateConverter() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
	}

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		Date date = (Date) source;
		writer.setValue(dateFormat.format(date));
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		return parser.parseLocalDateTime(reader.getValue()).toDate();
	}
}
