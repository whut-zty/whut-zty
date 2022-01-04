package cn.edu.whut.sept.imp;

import  java.util.HashMap;

import cn.edu.whut.sept.zuul.CommandWords;

/**
 * @author : [legendZHANG0915]
 */
public final class CommandFactory {

    /**
     * 不允许创建类的实例.
     */
    private CommandFactory() {

    }

    /**
     * 初始化处理程序(分别指向"help","go","quit"所指的类).
     */
    private static final HashMap<String, ProcessCommand>
            FACTORY = new HashMap<>();
    static {
        FACTORY.put("go", new ProcessGo());
        FACTORY.put("help", new ProcessHelp());
        FACTORY.put("quit", new ProcessQuit());
    }

    /**
     * 判断命令是否为空.
     */
    private static CommandWords commandwords = new CommandWords();

    /**
     *
     * @param command
     * @return 根据命令结果选择处理程序（类）
     */
    public static ProcessCommand get(final String command) {
        if (commandwords.isCommand(command)) {
            return FACTORY.get(command);
        } else {
            return new ProcessUnknown();
        }
    }
}
