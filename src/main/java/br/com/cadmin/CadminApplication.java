package br.com.cadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.cadmin.dao.UsuarioDAO;

@SpringBootApplication(scanBasePackages = { "br.com.cadmin.modelo", "br.com.cadmin.enumeracao", "br.com.cadmin.dao",
	"br.com.cadmin.service", "br.com.cadmin.controlador", "br.com.cadmin.validacao", "br.com.cadmin.configuracao",
	"br.com.cadmin.DTO", "br.com.cadmin.jwt" })
@EntityScan(basePackages = "br.com.cadmin.modelo")
@EnableJpaRepositories(basePackageClasses = UsuarioDAO.class)
public class CadminApplication {

    public static void main(String[] args) {
	SpringApplication.run(CadminApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder();
    }
}
