package mail.sender.controller;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class HealthCheckController {

  @GetMapping("status")
  @ResponseStatus(code = HttpStatus.OK)
  public HashMap<String, Object> getEmailStatus() {
    var response = new HashMap<String, Object>();

    response.put("service", "Mail-Sender");
    response.put("status", "up");
    response.put("httpStatus", HttpStatus.OK.value());

    return response;
  }
}
