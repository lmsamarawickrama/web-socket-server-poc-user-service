package org.saliam.smartbids.controller;

import org.saliam.smartbids.dto.user.UserCreateDto;
import org.saliam.smartbids.dto.user.UserDto;
import org.saliam.smartbids.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class UserWebSocketController
{
  private UserService userService;

  private SimpMessagingTemplate messageSender;

  @Autowired
  public void setUserService(UserService userService)
  {
    this.userService = userService;
  }

  @Autowired
  public void setMessageSender(SimpMessagingTemplate messageSender)
  {
    this.messageSender = messageSender;
  }

  @MessageMapping("/users")
  @SendTo("/topic/messages")
  public UserDto send(final UserCreateDto user)
  {
    return userService.save(user);
  }
}
