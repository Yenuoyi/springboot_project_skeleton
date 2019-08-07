package com.example.skeleton.controller;

import com.example.skeleton.common.basicMethod.BasicController;
import com.example.skeleton.domain.OnlineBugDTO;
import com.example.skeleton.service.OnlineBugService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yebing
 */
@RestController
@Api(description = "Bug控制器")
@RequestMapping("/onlineBug")
public class OnlineBugController extends BasicController<OnlineBugService, OnlineBugDTO> {
}
