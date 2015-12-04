/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factories;

import Commands.Abstract.AbstractCommand;
import Commands.Email.EmailCommand;
import Commands.GenericCrud.DeleteCommand;
import Commands.GenericCrud.InsertCommand;
import Commands.GenericCrud.PreDeleteCommand;
import Commands.GenericCrud.PreNewCommand;
import Commands.GenericCrud.PreUpdateCommand;
import Commands.GenericCrud.SearchAllCommand;
import Commands.GenericCrud.SearchKeyCommand;
import Commands.GenericCrud.UpdateCommand;
import Commands.Login.LoginCommand;
import Commands.Login.LogoutCommand;
import Commands.Login.RegisterCommand;
import Commands.Order.GetCustomerOrdersCommand;
import Commands.Order.ProcessOrderCommand;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class CommandFactory {
    
    private static CommandFactory cf = null;
    
    private CommandFactory(){}
    
    public synchronized static CommandFactory getInstance(){
        if(cf == null){
            cf = new CommandFactory();
        }
        return cf;
    }
    
    public synchronized AbstractCommand createCommand(String commandType, HttpServletRequest request, HttpServletResponse response){
        if(commandType.equalsIgnoreCase("searchall")){
            return new SearchAllCommand(request,response);
        } 
        else if(commandType.equalsIgnoreCase("searchkey")){
            return new SearchKeyCommand(request,response);
        } 
        else if(commandType.equalsIgnoreCase("login")){
            return new LoginCommand(request,response);
        } 
        else if(commandType.equalsIgnoreCase("logout")){
            return new LogoutCommand(request,response);          
        } 
        else if(commandType.equalsIgnoreCase("register")){
            return new RegisterCommand(request,response);          
        }         
        else if(commandType.equalsIgnoreCase("insert")){
            return new InsertCommand(request,response);
        }         
        else if(commandType.equalsIgnoreCase("update")){
            return new UpdateCommand(request,response);
        }
        else if(commandType.equalsIgnoreCase("delete")){
            return new DeleteCommand(request, response);
        }   
        else if(commandType.equalsIgnoreCase("email")){
            return new EmailCommand(request, response);
        }    
        else if(commandType.equalsIgnoreCase("createnew")){
            return new PreNewCommand(request, response);
        }        
        else if(commandType.equalsIgnoreCase("edit")){
            return new PreUpdateCommand(request, response);
        } 
        else if(commandType.equalsIgnoreCase("confirmdelete")){
            return new PreDeleteCommand(request, response);
        }          
        else if(commandType.equalsIgnoreCase("processorder")){
            return new ProcessOrderCommand(request, response);
        } 
        else if(commandType.equalsIgnoreCase("getcustomerorders")){
            return new GetCustomerOrdersCommand(request, response);
        }          
        
        return null;
    }

}
