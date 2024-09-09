package pe.mil.util;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import pe.mil.entity.*;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("/Pago/CP")
public class ComprobantePdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Pago objeto= (Pago) model.get("pago");
		document.setPageSize(PageSize.LETTER);
		document.open();
		PdfPTable tablaTi=new PdfPTable(1);
		PdfPCell celda=null;
		PdfPTable tablasub=new PdfPTable(1);
		PdfPCell celdas=null;
		
		com.lowagie.text.Font fuenteTit = FontFactory.getFont("Helvetica",18,Color.BLUE);
		com.lowagie.text.Font fuentesub = FontFactory.getFont("Helvetica",14,Color.BLUE);
		
		celda = new PdfPCell(new Phrase("Comprobante de Pago - Colegio 'Mil Maravillas'",fuenteTit));	
		celdas = new PdfPCell(new Phrase("'Una Sola Alma y Un Solo Corazón en Dios'",fuentesub));
		
		celda.setBorder(0);
		celdas.setBorder(0);
		celda.setBackgroundColor(new Color(40,190,138));
		celdas.setBackgroundColor(new Color(40,190,138));
		celda.setHorizontalAlignment(Element.ALIGN_CENTER);
		celdas.setHorizontalAlignment(Element.ALIGN_CENTER);
		celda.setVerticalAlignment(Element.ALIGN_CENTER);
		celdas.setVerticalAlignment(Element.ALIGN_CENTER);
		celda.setPaddingTop(15);
		celda.setPaddingBottom(3);
		celdas.setPadding(10);
		
		tablaTi.addCell(celda);		
		tablasub.addCell(celdas);
		tablasub.setSpacingAfter(30);
		
		PdfPTable tabla1=new PdfPTable(4);
		
		tabla1.addCell("Código de Pago");
		tabla1.addCell("Fecha de Pago");
		tabla1.addCell("Monto Pagado");
		tabla1.addCell("Estado");		
		tabla1.addCell(objeto.getId().toString());		
		tabla1.addCell(objeto.getFecha().toString());
		tabla1.addCell(objeto.getMonto().toString());
		tabla1.addCell(objeto.getEstado());
		tabla1.setSpacingAfter(30);
		
		PdfPTable tabla2=new PdfPTable(4);
		tabla2.addCell("Concepto");
		tabla2.addCell("Mes");
		tabla2.addCell("Fecha Límite");
		tabla2.addCell("Programado");		
		tabla2.addCell(objeto.getCalendario().getConcepto());		
		tabla2.addCell(objeto.getCalendario().getMes());
		tabla2.addCell(objeto.getCalendario().getFlimite().toString());
		tabla2.addCell(objeto.getCalendario().getMonto().toString());
		tabla2.setSpacingAfter(30);
		
		PdfPTable tabla3=new PdfPTable(3);
		tabla3.addCell("Alumno");
		tabla3.addCell("Apellidos");
		tabla3.addCell("Dni Alumno");			
		tabla3.addCell(objeto.getMatricula().getAlumno().getNombres());		
		tabla3.addCell(objeto.getMatricula().getAlumno().getApellidos());
		tabla3.addCell(objeto.getMatricula().getAlumno().getDni().toString());	
		tabla3.setSpacingAfter(30);
		
		PdfPTable tabla4=new PdfPTable(3);
		tabla4.addCell("Cajero");
		tabla4.addCell("Apellidos");
		tabla4.addCell("Usuario");		
		tabla4.addCell(objeto.getUsuari().getNombre());		
		tabla4.addCell(objeto.getUsuari().getApellidos());
		tabla4.addCell(objeto.getUsuari().getUser());
			
		document.add(tablaTi);
		document.add(tablasub);
		document.add(tabla1);
		document.add(tabla2);
		document.add(tabla3);
		document.add(tabla4);
	}

}
