package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class FileDownloadView extends AbstractView {

	//생성자에서는 MIME 타입설정
    public FileDownloadView(){
        setContentType("application/download; charset=utf-8");
    }
        
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model,
            HttpServletRequest req, HttpServletResponse res) throws Exception {
       
    	//실제 저장된 파일명
        File file = (File) model.get("downloadFile");
        String oriFileName = (String) model.get("oriFileName");

        //model객체에서 파일명을 얻어온 후 다운로드를 진행함
        
        res.setContentType(getContentType());
        res.setContentLength((int) file.length());
        res.setHeader("Content-Disposition", "attachment; filename=\"" + 
                java.net.URLEncoder.encode(oriFileName, "utf-8") + "\";");
        res.setHeader("Content-Transfer-Encoding", "binary");
        
        //입출력 스트림을 통해서 파일을 읽어옴
        OutputStream out = res.getOutputStream();
        FileInputStream fis = null;
        
        try {          
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try { 
                    fis.close(); 
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }        
        out.flush();
    }
}


