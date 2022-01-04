package cn.edu.whut.sept.imp;

import cn.edu.whut.sept.zuul.Command;
import cn.edu.whut.sept.zuul.Room;

/**
 * if条件判断中的"go"命令.
 * @author : [legendZHANG0915]
 */
public class ProcessGo implements ProcessCommand {

    /**
     * 重写接口方法.
     */
    @Override
    public boolean processCommand(final Command command) {
        Room currentRoom = Game.getRoom();
        goRoom(command, currentRoom);
        return false;
    }
    private void goRoom(final Command command, final Room currentRoom) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            Game.setRoom(nextRoom);
            System.out.println(Game.getRoom().getLongDescription());
        }
    }
}
