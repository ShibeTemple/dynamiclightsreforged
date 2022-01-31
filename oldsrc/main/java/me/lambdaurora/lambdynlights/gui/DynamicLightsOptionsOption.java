/*
 * Copyright © 2020 LambdAurora <aurora42lambda@gmail.com>
 *
 * This file is part of LambDynamicLights.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package me.lambdaurora.lambdynlights.gui;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.options.Option;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public final class DynamicLightsOptionsOption extends Option {
    private static final String KEY = "lambdynlights.menu.title";
    private final Text text;

    private final Screen parent;

    public DynamicLightsOptionsOption(Screen parent) {
        super(KEY);
        this.text = new TranslatableText(KEY);
        this.parent = parent;
    }

    @Override
    public AbstractButtonWidget createButton(GameOptions options, int x, int y, int width) {
        return new ButtonWidget(x, y, width, 20, this.text, btn -> MinecraftClient.getInstance().openScreen(new SettingsScreen(this.parent)));
    }
}
