package cn.edu.whut.sept.imp;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Parser;

/**
 * if条件判断中的"help"命令.
 * @author : [legendZHANG0915]
 */
public class ProcessHelp implements ProcessCommand {

    /**
     * 命令解析器.
     */
    private Parser parser;

    /**
     * 初始化parser.
     */
    public ProcessHelp() {
        this.parser = new Parser();
    }

    /**
     * 重写接口方法.
     */
    @Override
    public boolean processCommand(final Command command) {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        return false;
    }
}
