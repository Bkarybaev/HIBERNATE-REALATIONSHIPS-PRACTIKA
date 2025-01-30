package java16.config;

import jakarta.persistence.EntityManagerFactory;
import java16.models.Comment;
import java16.models.Post;
import java16.models.Profile;
import java16.models.User;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DataBaseConfig {
    public static EntityManagerFactory getEntityManager(){
        Properties props = new Properties();
        props.put(Environment.JAKARTA_JDBC_URL,"jdbc:postgresql://localhost:5432/java16");
        props.put(Environment.JAKARTA_JDBC_USER,"postgres");
        props.put(Environment.JAKARTA_JDBC_PASSWORD,"baiel123");
        props.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
        props.put(Environment.HBM2DDL_AUTO,"update");
        props.put(Environment.SHOW_SQL,true);

        Configuration cfg = new Configuration();
        cfg.setProperties(props);
        cfg.addAnnotatedClass(Post.class);
        cfg.addAnnotatedClass(Profile.class);
        cfg.addAnnotatedClass(User.class);
        cfg.addAnnotatedClass(Comment.class);


        return cfg.buildSessionFactory().unwrap(EntityManagerFactory.class);
    };
}
