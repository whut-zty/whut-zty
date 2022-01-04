package cn.edu.whut.sept.imp;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Parser;
import cn.edu.whut.sept.zuul.Room;

/**
 * 该类是“World-of-Zuul”应用程序的主类。
 * 《World of Zuul》是一款简单的文本冒险游戏。用户可以在一些房间组成的迷宫中探险。
 * 你们可以通过扩展该游戏的功能使它更有趣!.
 *
 * 如果想开始执行这个游戏，用户需要创建Game类的一个实例并调用“play”方法。
 *
 * Game类的实例将创建并初始化所有其他类:它创建所有房间，并将它们连接成迷宫；它创建解析器
 * 接收用户输入，并将用户输入转换成命令后开始运行游戏。
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 1.0
 */

public class Game {
    /**
     * 命令解析器.
     */
    private Parser parser;

    /**
     * 保存玩家当前的位置.
     */
    private static Room currentRoom;

    /**
     *
     * @return 返回玩家位置.
     */
    public static Room getRoom() {
        return currentRoom;
    }

    /**
     * 创建游戏并初始化内部数据和解析器.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * 创建所有房间对象并连接其出口用以构建迷宫.
     */
    private void createRooms() {
        Room outside;
        Room theater;
        Room pub;
        Room lab;
        Room office;
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
    }

    /**
     *  游戏主控循环，直到用户输入退出命令后结束整个程序.
     */
    public void play() {
        printWelcome();

        // Enter the main command loop.
        // Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            String word = command.getCommandWord();
            ProcessCommand process = CommandFactory.get(word);
            finished = process.processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * 向用户输出欢迎信息.
     */
    private  void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.print("World of Zuul is a new, ");
        System.out.println("incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * 修改玩家位置.
     * @param nextRoom 玩家的下一个位置.
     */
    public static void setRoom(final Room nextRoom) {
        currentRoom = nextRoom;
    }
}
