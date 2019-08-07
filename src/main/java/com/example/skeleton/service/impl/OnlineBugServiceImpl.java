package com.example.skeleton.service.impl;

import com.example.skeleton.common.basicMethod.BasicServiceImpl;
import com.example.skeleton.dao.OnlineBugDao;
import com.example.skeleton.domain.OnlineBugDTO;
import com.example.skeleton.service.OnlineBugService;
import org.springframework.stereotype.Service;

/**
 * @author yebing
 */
@Service
public class OnlineBugServiceImpl extends BasicServiceImpl<OnlineBugDao, OnlineBugDTO> implements OnlineBugService {
}
