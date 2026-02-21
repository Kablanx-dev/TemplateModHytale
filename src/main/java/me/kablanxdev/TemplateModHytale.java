package me.kablanxdev;

// ============================================================================
//                    MI PRIMER MOD PARA HYTALE
// ============================================================================
//
//  Bienvenido! Este es el archivo principal de tu mod.
//  Aqui es donde todo empieza cuando Hytale carga tu mod.
//
//  IMPORTANTE: El paquete (me.kablanxdev) debe coincidir con:
//    1. La estructura de carpetas: src/main/java/me/kablanxdev/
//    2. El entry_point en gradle.properties: me.kablanxdev.TemplateModHytale
//
// ============================================================================

import java.util.logging.Level;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.universe.PlayerRef;

/**
 * Clase principal del mod.
 * 
 * Esta clase DEBE:
 *   1. Extender JavaPlugin
 *   2. Tener un constructor que reciba JavaPluginInit
 *   3. Llamar a super(init) en el constructor
 * 
 * Es similar a como funcionan los plugins de Minecraft con Bukkit/Spigot.
 */
public class TemplateModHytale extends JavaPlugin {

    // ========================================================================
    // CONSTRUCTOR
    //
    // Hytale llama a este constructor automaticamente cuando carga el mod.
    // El parametro "init" contiene informacion sobre el mod.
    //
    // IMPORTANTE: NO hagas nada aqui excepto llamar a super(init)
    // ========================================================================
    public TemplateModHytale(@NonNullDecl JavaPluginInit init) {
        super(init);
    }

    // ========================================================================
    // METODO SETUP - AQUI INICIALIZAS TODO!
    //
    // Called during the initial setup phase, after configs are loaded. Use this for:

    //      - Preparing resources that don’t depend on other plugins
    //      - Early initialization logic
    //      - Accessing loaded configuration values
    // ========================================================================
    @Override
    protected void setup() {
        // Siempre llama a super.setup() primero
        // Do not register commands or events in setup(). 
        // Other plugins may not be loaded yet.
        super.setup();
        getLogger().at(Level.INFO).log("Setup complete!");
    }

    @Override
    public void start(){
        super.start();
        // --------------------------------------------------------------------
        // REGISTRAR COMANDOS
        // --------------------------------------------------------------------
        // getCommandRegistry() te da acceso al sistema de comandos de Hytale
        // registerCommand() agrega tu comando para que los jugadores lo usen
        getCommandRegistry().registerCommand(new ComandoSaludo());

        // Register events
        getEventRegistry().register(PlayerConnectEvent.class, this::onPlayerConnect);
        
        // --------------------------------------------------------------------
        // MENSAJE EN LA CONSOLA
        // --------------------------------------------------------------------
        // Esto imprime un mensaje en la consola del servidor cuando el mod carga
        // Es util para saber que el mod se cargo correctamente
        //
        // Niveles disponibles:
        //   Level.INFO    - Mensaje normal
        //   Level.WARNING - Advertencia (amarillo)
        //   Level.SEVERE  - Error grave (rojo)
        // --------------------------------------------------------------------
        getLogger().at(Level.INFO).log("Plugin started!");
    }

    private void onPlayerConnect(PlayerConnectEvent event) {
        // See PlayerRef documentation for thread-safe player references
        PlayerRef playerRef = event.getPlayerRef();
        getLogger().at(Level.INFO).log("Player connecting: " + playerRef.getUsername());
    }

}
