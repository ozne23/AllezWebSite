package Control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.output.*;

import Beans.Item;
import Beans.Prodotto;
import Model.ModelItem;

/**
 * Servlet implementation class RegItemServlet
 */
@WebServlet("/RegItemServlet")
public class RegItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 500 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;
	static ModelItem model = new ModelItem();
	
	
	public void init( ){
	      // Get the file location where it would be stored.
	     //filePath = getServletContext().getInitParameter("file-upload"); 
		//filePath = "/Users/lorenzofasolino/Desktop/TSW/Allez6/WebContent/images/"; //Lorenzo
		//filePath = "C:\\Users\\ozne2\\TSW\\Allez5\\WebContent\\images\\";
		//filePath ="\\Allez6.0\\WebContent\\images\\";
	   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//SE ESEGUITO CON TOMCAT
		filePath = request.getServletContext().getRealPath("")+"/images/";
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		//this will help you identify request is of type multipart or not.
		Item i = new Item();
		
		 
		ArrayList<FileItem> items = null;
		try {
			items = (ArrayList<FileItem>) new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (FileItem item : items) {
            if (item.isFormField() ) {
                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                String fieldname = item.getFieldName();
                String fieldvalue = item.getString();  
              
                if(fieldname.equalsIgnoreCase("taglia")) {
                	i.setTaglia(fieldvalue);
                }
                if(fieldname.equalsIgnoreCase("colore")) {
                	i.setColore(fieldvalue);
                }
                if(fieldname.equalsIgnoreCase("prodotto")) {
                	int value = Integer.parseInt(fieldvalue);
                	i.setProdotto(value);
                }
                if(fieldname.equalsIgnoreCase("sconto")) {
                	int value = Integer.parseInt(fieldvalue);
                	i.setSconto(value);
                }
                if(fieldname.equalsIgnoreCase("disp")) {
                	int value = Integer.parseInt(fieldvalue);
                	i.setDisponibilità(value);
                }
                if(fieldname.equalsIgnoreCase("prezzo")) {
                	int value = Integer.parseInt(fieldvalue);
                	i.setPrezzo(value);
                }
             
               
               
                	System.out.println(fieldname + ""+ fieldvalue);
               
            } else {
                // Process form file field (input type="file").
                String fieldname = item.getFieldName();
                String filename = FilenameUtils.getName(item.getName());
                FileItem filecontent = item;
                String fieldvalue = filename;
                System.out.println(fieldvalue);
                System.out.println(filePath);
                i.setImmagine("./images/"+fieldvalue);
               
                // ... (do your job here)
              if( filename.lastIndexOf("/") >= 0 ) {
	                  file = new File( filePath + filename.substring( filename.lastIndexOf("/"))) ;
	               } else {
	                  file = new File( filePath + filename.substring(filename.lastIndexOf("/")+1)) ;
	               }
	               try {
	            	
					item.write(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	               System.out.println("Uploaded Filename: " + filename + "<br>");
                
            }        
            
        }
        try {
        	System.out.println("ciao");
			model.doSave(i);
			System.out.println("ciao");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath() + "/RegistrazioneItem.jsp");
		}			
	}

		
}


