package cn.ki.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;
import cn.ki.serviceimpl.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserController Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>03/16/2019</pre>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/./applicationContext.xml","/./springmvc-servlet.xml"})
@Transactional
@Rollback()
@WebAppConfiguration
public class UserControllerTest {

    @Autowired
    private UserController usercontroller;

    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private String url;

    @Before
    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(usercontroller).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext ).build();
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
//        String responseString = mockMvc.perform(
//                get("/a/u").contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .param("id","1")).andExpect(status().isOk())    //返回的状态是200
//                .andDo(print())         //打印出请求和相应的内容
//                .andReturn().getResponse().getContentAsString();
//        System.out.println("Controller层：返回的数据:" + responseString);
//        url="/a/u";
//        ResultActions resultActions =
//                this.mockMvc.perform(MockMvcRequestBuilders.post(url).param("id", "1"));
//        MvcResult mvcResult = resultActions.andReturn();
//        String result = mvcResult.getResponse().getContentAsString();
//        System.out.println("Controller层：返回的数据:" + result);
//        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/a/u" );
//        mockHttpServletRequestBuilder.param("id", "1" );
//        ResultActions resultActions = mockMvc.perform( mockHttpServletRequestBuilder );
//        resultActions.andExpect(status().isOk());
//        .param("id","1")
        String responseString = mockMvc.perform(MockMvcRequestBuilders.get("/a/u/users/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println("哈哈哈"+responseString);
    }

    @After
    public void after() throws Exception {
        System.out.println("结束");
    }
} 
