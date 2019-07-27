package app.clinkApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSourc
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
@RestController
public class ClinkApi {

	public static void main(String[] args) {
		SpringApplication.run(ClinkApi.class, args);
	 

	}
	
	
	
	
	
	
	/*@RequestMapping(value="/upload",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object>UploadFile(@RequestParam("file")MultipartFile file) throws IOException
	{
		File convertFile=new File("F:\\CDAC\\EasyExchange\\storage\\"+file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout=new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		
		
		return new ResponseEntity<>("file uploaded successfully",HttpStatus.OK);
		
	}
	*/
	@Bean
	public CorsFilter corsFilter() {
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);
	config.addAllowedOrigin("*");
	config.addAllowedHeader("*");
	config.addAllowedMethod("OPTIONS");
	config.addAllowedMethod("GET");
	config.addAllowedMethod("POST");
	config.addAllowedMethod("PUT");
	config.addAllowedMethod("DELETE");
	source.registerCorsConfiguration("/**", config);
	return new CorsFilter(source);
	}







}
