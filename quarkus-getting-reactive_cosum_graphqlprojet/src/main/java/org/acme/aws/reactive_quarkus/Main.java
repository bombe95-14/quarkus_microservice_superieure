package org.acme.aws.reactive_quarkus;

import java.util.logging.Level;
import java.util.logging.Logger;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
    public class Main implements QuarkusApplication {
        public static final Logger LOGGER = Logger.getLogger(Main.class.getName());    
        
         @Inject
        EleveService eleveService; 
        
        @Override
        public int run(String... args) throws Exception {
             this.eleveService.globalListStudent().forEach(
                p -> LOGGER.log(Level.INFO, "post: {0}", p)
            ); 
            return 0;
        }
    }