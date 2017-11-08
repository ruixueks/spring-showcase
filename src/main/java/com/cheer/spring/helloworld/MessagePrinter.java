/*
 * 文件名：MessagePrinter.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Administrator
 * 修改时间：2017年11月7日
 */

package com.cheer.spring.helloworld;

public class MessagePrinter
{
    private MessageService msgService;
    
    public MessageService getMsgService()
    {
        return msgService;
    }

    public void setMsgService(MessageService msgService)
    {
        this.msgService = msgService;
    }

    public void printMessage()
    {
        System.out.print(this.msgService.getMessage());
    }
}
