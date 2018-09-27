package com.huawei.frs.demo;


import com.huawei.frs.client.FrsClient;
import com.huawei.frs.result.*;

public class FrsSdkDemo {

    private static void frsSdkDemo() throws Exception {

        //1. 配置访问人脸服务的基本信息
        String ak = "ADDREFEWF23ADSA";
        String sk = "61THGChlc6PxVJjsd2d32f4PoKPI5ZqWyt8cQbIw";
        String projectId = "38c7e4bc9eb94af4546jd54393c7293cc0";
        //String endpoint = "https://face.cn-north-1.myhuaweicloud.com";
        //String region = "cn-north-1";
        //1.a 此处支持使用代理方式访问人脸识别服务，用于不能直接访问华为云官网的情况，例如内网网络。

//        ProxyHostInfo proxyHostInfo = new ProxyHostInfo(
//                "proxy.huawei.com", /*代理主机信息*/
//                8080,                     /*代理主机端口*/
//                "xxxxxxx",          /*代理用户名*/
//                "xxxxxxxx"           /*代理用户密码*/
//        );
//        try(FrsClient frsClient = new FrsClient(ak, sk, projectId, proxyHostInfo)){
        //初始化FrsClient, 通过try-with-resources的方式调用frsClient, java 7 以上版本支持。
        //AuthInfo authInfo = new AuthInfo(endpoint, region, ak, sk);
        //FrsClient frsClient = new FrsClient(authInfo, projectId, proxyHostInfo);
        try (FrsClient frsClient = new FrsClient(ak, sk, projectId)) {

            //调用服务前确保已在华为云开通了人脸识别服务

            //创建人脸集
            String faceSetName = "faceSetName";
            CreateFaceSetResult createFaceSetResult = frsClient.getFaceSetService().createFaceSet(faceSetName, 10000);
            System.out.println("create face set: ");
            System.out.println(createFaceSetResult.toJSONString());

            //获取人脸集
            GetFaceSetResult getFaceSetResult = frsClient.getFaceSetService().getFaceSet(faceSetName);

            //向人脸集添加人脸1
            String externalImageId1 = "externalImageId1";
            AddFaceResult addFaceResult1 = frsClient.getFaceService().addFaceByFile(faceSetName, externalImageId1, "data/face1.jpg");
            System.out.println("add face by file: ");
            System.out.println(addFaceResult1.toJSONString());

            //向人脸集添加人脸2
            String externalImageId2 = "externalImageId2";
            AddFaceResult addFaceResult2 = frsClient.getFaceService().addFaceByFile(faceSetName, externalImageId2, "data/face2.jpg");
            System.out.println("add face by file: ");
            System.out.println(addFaceResult2.toJSONString());

            //人脸搜索
            SearchFaceResult searchFaceResult = frsClient.getSearchService().searchFaceByFile(faceSetName, "data/face3.jpg");
            System.out.println("search by file: ");
            System.out.println(searchFaceResult.toJSONString());

            //删除人脸集
            DeleteFaceSetResult deleteFaceSetResult = frsClient.getFaceSetService().deleteFaceSet(faceSetName);
            System.out.println("delete face set: ");
            System.out.println(deleteFaceSetResult.toJSONString());
        }
    }

    public static void main(String[] args) throws Exception {
        frsSdkDemo();
    }
}
