// Generated by Dagger (https://dagger.dev).
package edu.northeastern.cs5500.starterbot.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import edu.northeastern.cs5500.starterbot.model.Stuff;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RepositoryModule_ProvideStuffRepositoryFactory implements Factory<GenericRepository<Stuff>> {
  private final RepositoryModule module;

  public RepositoryModule_ProvideStuffRepositoryFactory(RepositoryModule module) {
    this.module = module;
  }

  @Override
  public GenericRepository<Stuff> get() {
    return provideStuffRepository(module);
  }

  public static RepositoryModule_ProvideStuffRepositoryFactory create(RepositoryModule module) {
    return new RepositoryModule_ProvideStuffRepositoryFactory(module);
  }

  public static GenericRepository<Stuff> provideStuffRepository(RepositoryModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideStuffRepository());
  }
}