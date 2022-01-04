package cn.edu.whut.sept.zuul;

/**
 * 该类描述了一个指令，指令的正常格式为：<Str1,Str2>或者为<Str,null>，前者是双指令，后者是单指令
 * 当Parser接收了一个不符合规范的首字符串后会产生一个不正常的指令格式：<null,str>。该指令无效
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    public String getCommandWord()
    {
        return commandWord;
    }

    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * 判断搜字符串是否符合规范
     * @return boolean 如果符合规范返回false，否则返回true
     */

    public boolean isUnknown()
    {
        return (commandWord == null);
    }



    /**
     * 判断指令的格式
     * @return boolean 如果指令是双指令格式返回true，单指令格式返回false
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
