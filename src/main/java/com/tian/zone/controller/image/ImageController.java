package com.tian.zone.controller.image;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Title:ImageController</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2018年10月4日 下午2:23:38
 **/
@Controller
@RequestMapping("/image")
public class ImageController {

	private static final Logger log = LoggerFactory.getLogger(ImageController.class);
	
	private static final String UPLOAD_PATH = "/upload/img/";
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	public void upload(@RequestParam("upload") MultipartFile file,HttpServletRequest request, HttpServletResponse response){
		log.info("upload image");
		try{
	        PrintWriter out = response.getWriter();
			String proPath = request.getSession().getServletContext().getRealPath("/");//当前程序目录，例如D:\eclipse-jee-neon\github_workspace1\pz\src\main\webapp
	        String proName = request.getContextPath();//上下文地址，/pz
	        String path = proPath + UPLOAD_PATH;
	        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");//文件数目
	        String orgFileName = file.getOriginalFilename();//文件原始名字 1.png
	        String fileName = orgFileName;
	        String uploadContentType = file.getContentType();//文件类型 image/png
	        String expandedName = "";
	        if (uploadContentType.equals("image/pjpeg")
	                || uploadContentType.equals("image/jpeg")) {
	            // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
	            expandedName = ".jpg";
	        } else if (uploadContentType.equals("image/png")
	                || uploadContentType.equals("image/x-png")) {
	            // IE6上传的png图片的headimageContentType是"image/x-png"
	            expandedName = ".png";
	        } else if (uploadContentType.equals("image/gif")) {
	            expandedName = ".gif";
	        } else if (uploadContentType.equals("image/bmp")) {
	            expandedName = ".bmp";
	        } else {
	            out.println("<script type=\"text/javascript\">");
	            out.println("window.parent.CKEDITOR.tools.callFunction("
	                    + CKEditorFuncNum + ",'',"
	                    + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
	            out.println("</script>");
	            return;
	        }
	        if (file.getSize() > 1024 * 1024 * 2) {
		        out.println("<script type=\"text/javascript\">");
	            out.println("window.parent.CKEDITOR.tools.callFunction("
	                    + CKEditorFuncNum + ",''," + "'文件大小不得大于2M');");
		        out.println("</script>");
	            return;
	        }
	        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	        fileName = df.format(new Date()) + expandedName;
	        file.transferTo(new File(path + "/" + fileName));
	        out.println("<script type=\"text/javascript\">");
	        out.println("window.parent.CKEDITOR.tools.callFunction("
	        		+ CKEditorFuncNum + ",'" + proName + UPLOAD_PATH
                    + fileName + "','文件:["+orgFileName +"]上传成功');");
	        out.println("</script>");
			log.info("上传成功！");
	        return;
	    } catch (Exception e) {
	        e.printStackTrace();
			try {
				PrintWriter out = response.getWriter();
		        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");//文件数目
	            out.println("<script type=\"text/javascript\">");
	            out.println("window.parent.CKEDITOR.tools.callFunction("+CKEditorFuncNum+",'','上传出错！');");
	            out.println("</script>");
			} catch (Exception ioe) {
				e.printStackTrace();
			}
	    }
	}
}
