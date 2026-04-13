package com.learnspring.blogapi.runner;

import com.learnspring.blogapi.services.PasswordMigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("migration")
public class MigrationRunner implements CommandLineRunner {

    @Autowired
    private PasswordMigrationService migrationService;

    @Override
    public void run(String...args) {
        System.out.println("Starting password migration...");
        migrationService.migrate();
        System.out.println("Migration complete!");
    }

}
