package com.codasoftwares.ecoc;

import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

/**
 * Created by jeffbustercase on 10/03/17.
 */
public class AssetManager extends com.badlogic.gdx.assets.AssetManager {
    AssetManager() {
        super();

        // Font Loader usando freetype
        InternalFileHandleResolver resolver = new InternalFileHandleResolver();
        setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
    }
    public BitmapFont getFont(String font, FreeTypeFontGenerator.FreeTypeFontParameter parameters){
        // Inicialização do carregamento de  terminada fonte
        FreetypeFontLoader.FreeTypeFontLoaderParameter fontLoaderParameter;
        fontLoaderParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();

        // Adiciona parametros indicados ( argumentos )
        fontLoaderParameter.fontFileName = "fonts/"+font;
        fontLoaderParameter.fontParameters = parameters; // Tamanho, efeitos etc.

        // Carrega fonte, caso ainda não tenha sido carregada
        if(!isLoaded(fontLoaderParameter.fontFileName, BitmapFont.class)){
            load(fontLoaderParameter.fontFileName, BitmapFont.class, fontLoaderParameter);
            finishLoading(); // espera até o termino do carregamento
        }
        // Retorna fonte já carregada
        return get(fontLoaderParameter.fontFileName, BitmapFont.class);
    }
}
