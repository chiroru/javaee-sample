package jp.ddo.chiroru.testing.resource;

public class PropertyLoaderFactory {

    private final static PropertyLoaderFactory instance = new PropertyLoaderFactory();

    private PropertyLoaderFactory() {
        // do nothing.
    }

    /**
     * {@code PropertyLoaderFactory} のインスタンスを返却します.
     * @return　{@code PropertyLoaderFactory} のインスタンス
     */
    public static PropertyLoaderFactory getFactory() {
        return instance;
    }

    /**
     * デフォルトの{@code PropertyLoader}のインスタンスを返却します.
     * デフォルトの{@code PropertyLoader}は、クラスパスからプロパティをロードする機能を提供する
     * {@link ClassPathPropertyLoader}のインスタンスです.ロードに関する仕様の詳細は、
     * {@link ClassPathPropertyLoader}のAPIマニュアルを参照して下さい.
     * @return デフォルトの{@code PropertyLoader}のインスタンス
     * @since 1.0.0
     * @see PropertyLoader
     * @see ClassPathPropertyLoader
     */
    public PropertyLoader getLoader() {
        return getLoader(StoreType.CLASSPATH);
    }

    /**
     * 指定された{@link StoreType}からのプロパティをロードする機能を提供する
     * {@code PropertyLoader}のインスタンスを返却します.
     * @return 指定された{@link StoreType}からのプロパティのロードをサポートする{@code PropertyLoader}のインスタンス
     * @since 1.0.0
     * @see PropertyLoader
     */
    public PropertyLoader getLoader(StoreType type) {
        PropertyLoader loader = null;

        switch (type) {
        case CLASSPATH :
            loader = ClassPathPropertyLoader.getInstance();
            break;
        default :
            break;
        }
        return loader;
    }
}
