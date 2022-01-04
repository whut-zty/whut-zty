package cn.edu.whut.sept.imp;

import cn.edu.whut.sept.zuul.Command;
/**
 * if条件判断中的unknown.
 * @author : [legendZHANG0915]
 */
public class ProcessUnknown implements ProcessCommand {

    /**
     * 重写接口方法.
     */
    @Override
    public boolean processCommand(final Command command) {
        System.out.println("I don't know what you mean...");
        return false;
    }
}
