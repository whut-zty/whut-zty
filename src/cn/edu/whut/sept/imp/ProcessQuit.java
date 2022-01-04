package cn.edu.whut.sept.imp;

import cn.edu.whut.sept.zuul.Command;
/**
 * if条件判断中的"quit"命令.
 * @author : [legendZHANG0915]
 */
public class ProcessQuit implements ProcessCommand {

    /**
     * 重写接口方法.
     */
    @Override
    public boolean processCommand(final Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
}
