package htyy.controller;

import htyy.domain.Account;
import htyy.service.IAccountService;
import htyy.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class HelloController {

    @Autowired
    private IAccountService service;

    @RequestMapping(path = "/hello")
    public String sayHello(String username, String password, Integer money, String[] from, HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println(username+password+money);
        if (from!=null){
        for (String s : from) {
            System.out.println(s);
        }}
        req.setCharacterEncoding("utf-8");
        String path=req.getSession().getServletContext().getRealPath("/uploads");
        File uploadFolder = new File(path);
        if(!uploadFolder.exists())uploadFolder.mkdirs();
//
//        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
//        List<FileItem> itemList = upload.parseRequest(req);
//        for (FileItem fileItem : itemList) {
//            if(fileItem.isFormField()){
//                System.out.println(new String(fileItem.getFieldName().getBytes("iso-8859-1"),"utf-8")+" value:"+
//                        new String(fileItem.getString().getBytes("iso-8859-1"),"utf-8"));
//            }else{
//                String fileName=fileItem.getName();
//                fileName= UUID.randomUUID().toString().replace("-","")+"_"+fileName;
//                fileItem.write(new File(uploadFolder,fileName));
//                fileItem.delete();
//                System.out.println(fileName+"上传成功");
//            }
//        }

        return "success";
    }

    @RequestMapping("/fileLoad")
    public String fileLoad(HttpServletRequest req,String username, String password, Integer money, String[] from, MultipartFile myFile) throws IOException {
        System.out.println(username+password+money);
        if (from!=null){
            for (String s : from) {
                System.out.println(s);
            }
        }
        String path=req.getSession().getServletContext().getRealPath("/uploads");
        String fileName= UUID.randomUUID().toString().replace("-","")+"_"+myFile.getOriginalFilename();
        myFile.transferTo(new File(path,fileName));
        return "success";
    }

    @RequestMapping(path = "/hello/{sid}")
    public ModelAndView testxx(@PathVariable("sid") Integer mit){
        System.out.println(mit);
        ModelAndView view = new ModelAndView();
        List<Account> accountList = service.findAll();
        view.addObject("allAccount", accountList);
        System.out.println(accountList);
        view.setViewName("success");
        return view;
    }

//    @ModelAttribute
//    public void testxxf(Model m){
//        Integer myint = new Integer(12);
//        m.addAttribute("mit",myint);
//    }
//
//    @ModelAttribute("myUser")
//    public User testxxfd(){
//        User user = new User();
//        user.setMoney(100);
//        user.setName("yy");
//        return user;
//    }
}

