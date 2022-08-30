package com.gao.util;


import com.gao.pojo.TestUser;

@FunctionalInterface
public interface lamadaUtil {
    TestUser add(TestUser testUser);
}

/*package com.gao.util;

import com.gao.pojo.TestUser;

public class superLamadaUtil extends lamadaUtil{
    @Override
    public TestUser add(TestUser testUser) {
        super.add(testUser);
        return null;
    }
}
super可访问继承
*/