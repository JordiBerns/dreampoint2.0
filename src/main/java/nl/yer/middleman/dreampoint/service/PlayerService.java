package nl.yer.middleman.dreampoint.service;

import nl.yer.middleman.dreampoint.persistence.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    
}
