package io.common.apiserver.entity;


public class MenuMeta {
    public MenuMeta(){

    }

    public MenuMeta(boolean keepAlive, boolean requireAuth) {
        this.keepAlive = keepAlive;
        this.requireAuth = requireAuth;
    }

    private boolean keepAlive;
    private boolean requireAuth;

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
