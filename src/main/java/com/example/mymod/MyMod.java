package com.example.mymod;

import org.fogofwarlabs.sc4j.base.log.Logger;
import org.fogofwarlabs.sc4j.engine.mod.Mod;
import org.fogofwarlabs.sc4j.engine.mod.ModContext;
import org.fogofwarlabs.sc4j.engine.mod.ModRegistration;

/**
 * The mod's entry, named by {@code entry} in {@code sc4j-mod.json}: a headless runner that logs one line and the first screen of the
 * window run.
 */
public final class MyMod implements Mod {
    private Logger logger;

    @Override
    public void initialize(ModContext context) {
        this.logger = context.getLogger();
    }

    @Override
    public void register(ModRegistration registration) {
        Logger log = this.logger;

        registration.registerHeadlessRunner(launch -> log.info("MOD: headless run of {0}", launch.getIdentity()));
        registration.registerFirstScene(FirstScene::new);
    }

    @Override
    public void close() {
        this.logger = null;
    }
}
