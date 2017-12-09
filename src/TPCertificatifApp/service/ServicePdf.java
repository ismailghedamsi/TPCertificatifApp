package TPCertificatifApp.service;



import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import TPCertificatifApp.bean.*;



public class ServicePdf {
	RegistredUsers userList;
	public ServicePdf(RegistredUsers userList) {
		super();
		this.userList = userList;
		
	}
	
	private PdfPCell celluleSansBordure(String str) {
		PdfPCell cell = new PdfPCell();
		Font font = new Font();
		cell.setBorder(0); // aucune bordure
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.addElement(new Paragraph(str,font)); // ajout du texte et de la police
		return cell;
	}
	
	//Example barcode avec itext
	private Image addBarCode(PdfWriter writer,PdfPTable table) {
		PdfContentByte cByte = writer.getDirectContent(); 
		//BarcodeEAN codeEan = new BarcodeEAN();
		Barcode128 b128 = new Barcode128();
		b128.setCode(new Date().getTime()+"");
		Image imageEAN = b128.createImageWithBarcode(cByte, null, null);
		//ajout dans la celule
		PdfPCell cell = new PdfPCell(imageEAN,false);
		cell.setPaddingTop(10);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(2);
		cell.setBorder(0);
		//Ajout dans le pdf
		table.addCell(cell);
		return imageEAN;
	}
	
	private PdfPTable genererTableauUtilisateur() {
		PdfPTable table = new PdfPTable(3); // tableau de deux colonnes
		for (AbstractUser user : userList.getListUsers()) {
			table.addCell(user.getFirstName() + user.getLastName());
			table.addCell(user.getAge()+"");
			table.addCell(user.getPoints()+"");
		}
	
		return table;
	}
	
	private PdfPTable genererEnTeteTableau(AbstractUser user,String logoPath) throws Exception {
		PdfPTable tableauHeader = new PdfPTable(4); // tableau a deux colonnes
		//inserer le logo
		Image image = Image.getInstance(logoPath);
		image.setAlignment(Element.ALIGN_LEFT);
		image.scalePercent(25);
		PdfPCell cell = new PdfPCell(image,false);
		cell.setBorder(0);
		tableauHeader.addCell(cell);
		tableauHeader.addCell(celluleSansBordure("Nom Client"));
		tableauHeader.addCell(celluleSansBordure(user.getFirstName()));
		tableauHeader.addCell(celluleSansBordure("Prenom Client "));
		tableauHeader.addCell(celluleSansBordure(user.getLastName()));
		tableauHeader.addCell(celluleSansBordure("Age Client"));
		tableauHeader.addCell(user.getAge()+"");
		return tableauHeader;
	}
	
	public void generateCommandePDF(String pathPDF ) throws Exception{
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(pathPDF));
			document.open();
			PdfPTable tableau = genererTableauUtilisateur();
			PdfPTable tableauHeader = genererEnTeteTableau(userList.getListUsers().get(0), "/home/small44/entite.jpg");
			addBarCode(writer, tableauHeader);
			document.add(tableau);
			
			//Generer une simple ligne avec un lien
			Paragraph paragraphe = new Paragraph("Site Cegep");
			Anchor anchor = new Anchor("http://www.google.com",FontFactory.getFont(FontFactory.TIMES_ROMAN,13,Font.UNDERLINE));
			paragraphe.add(anchor);
			document.add(paragraphe);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
