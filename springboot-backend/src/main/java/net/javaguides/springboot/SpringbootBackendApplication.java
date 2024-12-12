// package net.javaguides.springboot;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class SpringbootBackendApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(SpringbootBackendApplication.class, args);
// 	}

// }



package net.javaguides.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

    // Injection de JdbcTemplate pour interagir avec la base de données
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            // Effectuer une requête simple pour tester la connexion à la base de données
            String query = "SELECT 1";
            Integer result = jdbcTemplate.queryForObject(query, Integer.class);

            // Vérifier le résultat et afficher un message
            if (result != null && result == 1) {
                System.out.println("Connexion à MySQL réussie!");
            } else {
                System.out.println("Échec de la connexion à MySQL.");
            }
        } catch (Exception e) {
            // En cas d'exception, afficher un message d'erreur
            System.out.println("Erreur lors de la connexion à MySQL: " + e.getMessage());
        }
    }
}
