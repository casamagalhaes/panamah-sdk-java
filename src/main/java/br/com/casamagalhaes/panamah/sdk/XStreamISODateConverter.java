package br.com.casamagalhaes.panamah.sdk;

import java.util.Date;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class XStreamISODateConverter implements Converter {

	DateTimeFormatter parser = ISODateTimeFormat.dateTimeParser();

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		Date date = (Date) source;
		writer.setValue(parser.print(date.getTime()));
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		return parser.parseLocalDateTime(reader.getValue()).toDate();
	}
}
