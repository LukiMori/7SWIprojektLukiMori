package cz.osu.finalproject7swi.controller;

import cz.osu.finalproject7swi.model.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @Value("${app.name}")
    private String appName;
    private final AppUserRepository userRepo;

    public MainController(AppUserRepository userRepo) {
        this.userRepo = userRepo;
    }
}
