package me.kablanxdev;

// ============================================================================
//                        COMANDO /SALUDO
// ============================================================================
//  Este es un comando super sencillo que responde "Hola Mundo!"
//  cuando un jugador escribe /saludo en el chat.
// ============================================================================

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;

/**
 * Un comando basico para Hytale.
 * 
 * Hay varios tipos de comandos que puedes usar:
 *   - CommandBase: El mas sencillo, para comandos basicos
 *   - AbstractAsyncCommand: Para comandos que pueden tardar (consultas, etc.)
 *   - MacroCommandBase: Para comandos mas complejos (aun sin documentar)
 * 
 * Para este tutorial usamos CommandBase porque es el mas facil de entender.
 */
public class ComandoSaludo extends CommandBase {

    // ========================================================================
    // CONSTRUCTOR
    //
    // Aqui defines el nombre del comando y su descripcion.
    // El nombre es lo que va despues del / en el chat.
    // ========================================================================
    public ComandoSaludo() {
        // super(nombre, descripcion)
        // - nombre: "saludo" -> el jugador escribira /saludo
        // - descripcion: aparece cuando el jugador escribe /help
        super("saludo", "Mi primer comando - dice hola!");
    }

    // ========================================================================
    // METODO EXECUTESYNC - AQUI VA LA LOGICA DEL COMANDO!
    //
    // Este metodo se ejecuta cada vez que un jugador usa el comando.
    // El "context" contiene toda la info: quien lo ejecuto, argumentos...
    // ========================================================================
    @Override
    public void executeSync(CommandContext context) {
        // ====================================================================
        // ENVIAR UN MENSAJE AL JUGADOR
        // ====================================================================
        // 
        // context.sendMessage() envia un mensaje a quien ejecuto el comando
        //
        // Message.raw() crea un mensaje de texto. Es la forma correcta de crear 
        // mensajes en Hytale.
        // ====================================================================
        
        context.sendMessage(Message.raw("Hola Mundo! Tu primer mod funciona!"));
    }
}
