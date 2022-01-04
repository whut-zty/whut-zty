package cn.edu.whut.sept.imp;

import cn.edu.whut.sept.zuul.Command;
/**
 * if多条件判断优化：策略模式.
 * @author : [legendZHANG0915]
 */

public interface ProcessCommand {

    /**
     * @param command
     * @return 返回命令处理后的结果
     */
    boolean processCommand(Command command);
}
