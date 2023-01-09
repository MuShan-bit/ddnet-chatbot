package xyz.mushan.simple2.module.ddnet.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import xyz.mushan.simple2.module.ddnet.entity.po.DDnetUser;
import xyz.mushan.simple2.module.ddnet.service.DDnetService;
import xyz.mushan.simple2.utils.HttpUtil;

import java.util.List;
import java.util.Optional;

/**
 * @author mushan
 * @date 2022/12/30
 * @apiNote
 */
@Service
public class DDnetServiceImpl implements DDnetService {
    static final String POINTS_QUERY_API = "https://ddnet.org/players/?query=";

    @Override
    public Long queryPoints(String name) {
        String result = HttpUtil.get(POINTS_QUERY_API + name);
        List<DDnetUser> list = JSON.parseArray(result).toJavaList(DDnetUser.class);
        Optional<DDnetUser> user = list.stream().filter(it -> name.equals(it.getName())).findFirst();
        return user.map(DDnetUser::getPoints).orElse(0L);
    }
}
