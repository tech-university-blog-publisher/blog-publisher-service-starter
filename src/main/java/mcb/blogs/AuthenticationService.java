package mcb.blogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authenticate")
@Scope("request")
public class AuthenticationService {
    private BlogUser user;

    @Autowired
    public AuthenticationService(BlogUser user) {
        this.user = user;
    }

    @PostMapping
    public ResponseEntity authenticate(@RequestBody AuthenticationRequest request) {
        // generate JWT
        return ResponseEntity.ok(request);
    }
}
