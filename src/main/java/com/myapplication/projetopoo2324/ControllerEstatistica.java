package com.myapplication.projetopoo2324;


import java.io.IOException;

/**
 *
 * @author tomas
 */
public class ControllerEstatistica {
    
    public static void run(Estado estado, String email) throws IOException {

        while (true) {
            try{        
                int opcao = -1;
                while (opcao < 0 || opcao > 12) {
                    opcao = Menu.menuEstatisticas();
                }

                switch (opcao) {
                    case 1:
                 Menu.limpaTerminal();               
                  Menu.firstQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                        
                    case 2:
                   Menu.limpaTerminal(); 
                  Menu.secondQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                    case 3:
                        Menu.limpaTerminal(); 
                  Menu.thirdQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                    case 4:  Menu.limpaTerminal(); 
                  Menu.fourthQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                        
                    case 5: 
                         Menu.limpaTerminal(); 
                  Menu.fifthQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                        
                  case 6:
                         Menu.limpaTerminal(); 
                  Menu.sixthQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                        
                    case 7: 
                         Menu.limpaTerminal(); 
                  Menu.seventhQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                        
                    case 8: 
                         Menu.limpaTerminal(); 
                  Menu.eighthQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                    case 9: 
                         Menu.limpaTerminal(); 
                  Menu.ninthQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                        
                        
                    case 10: 
                         Menu.limpaTerminal(); 
                  Menu.tenthQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                      
                        
                    case 11:           
                         Menu.limpaTerminal(); 
                  Menu.eleventhQuery(estado); 
                  Menu.pressToContinue(); 
                        break;
                                                   
                        
                    case 0:
                        Menu.limpaTerminal();
                        ControllerUtilizador.run(estado,email);
                        break;
     
                        
                }
                
            }
            catch(java.util.InputMismatchException e){
                Menu.errors(7);
                Menu.pressToContinue();
            }
        }
    }
}
