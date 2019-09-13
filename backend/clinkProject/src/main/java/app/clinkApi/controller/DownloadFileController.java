package app.clinkApi.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import app.clinkApi.repository.FileRepository;
 
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DownloadFileController {
	
	
	@Autowired
	FileRepository fileRepository;

	/*
	 * List All Files
	 */
  /*  @JsonView(View.FileInfo.class)
    @GetMapping("/cars")
    public ResponseEntity<List<String>> getListFiles(Model model) {
      List<String> fileNames = files
          .stream().map(fileName -> MvcUriComponentsBuilder
              .fromMethodName(DownloadFileController.class, "getFile", fileName).build().toString())
          .collect(Collectors.toList());
   
      return ResponseEntity.ok().body(fileNames);
    }*/
	
		/*@GetMapping("/cars")
	public ResponseEntity<Multi> getListFiles() throws IOException {
		List<FileModel> names=fileRepository.findAll();
    	ClassPathResource imgFile = new ClassPathResource("abc.png");
    	
    			 return ResponseEntity
    		                .ok()
    		                .contentType(MediaType.IMAGE_PNG)
    		                .body(new InputStreamResource(imgFile.getInputStream()));
    		 }*/
	
	/*@GetMapping(value="/cars")
	public  Map<String, String> getImage(@PathVariable String id) throws IOException {
        
		   File file = new ClassPathResource("abc.png").getFile();
		    
		   String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(file.toPath()));

		   Map<String, String> jsonMap = new HashMap<>();

		   jsonMap.put("content", encodeImage);

		   return jsonMap;
		}*/
   
	
	@GetMapping(value="/cars",produces = MediaType.IMAGE_PNG_VALUE)
	public  ResponseEntity<byte[]>  getListFiles() throws IOException{
		System.out.println("checking");
		byte[] []imgarr=new byte[2][];
		
		
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\abc.png";
	 imgarr[0]  = Files.readAllBytes(Paths.get(path));
	 imgarr[1] = Files.readAllBytes(Paths.get(path));
	// byte[] img= Base64.encodeBase64(imgarr[0]);
	// String image=new String(img, "UTF-8");
	// List<byte[]> imgList=new ArrayList<>();
	
	 
	    return ResponseEntity.ok().body(imgarr[0]);
    		                
	}

		
	
	
    /*
     * Download Files
     */
	/*@GetMapping("/api/file/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
		Optional<FileModel> fileOptional = fileRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			FileModel file = fileOptional.get();
			return ResponseEntity.ok()
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
					.body(file.getPic());	
		}
		
		return ResponseEntity.status(404).body(null);
	}*/
}
