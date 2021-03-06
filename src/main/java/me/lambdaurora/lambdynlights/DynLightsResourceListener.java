package me.lambdaurora.lambdynlights;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.lambdaurora.lambdynlights.api.item.ItemLightSources;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;

import java.util.function.Predicate;

public class DynLightsResourceListener implements ISelectiveResourceReloadListener
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().setLenient().create();

    @Override
    public void onResourceManagerReload(IResourceManager manager, Predicate<IResourceType> resourcePredicate)
    {
        ItemLightSources.load(manager);
    }
}

