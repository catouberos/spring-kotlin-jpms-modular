{
  inputs.nixpkgs.url = "github:nixos/nixpkgs/nixpkgs-unstable";

  outputs = {
    self,
    nixpkgs,
  }: let
    javaVersion = 21;

    supportedSystems = ["x86_64-linux" "aarch64-linux" "x86_64-darwin" "aarch64-darwin"];
    forEachSupportedSystem = f:
      nixpkgs.lib.genAttrs supportedSystems (system:
        f {
          pkgs = import nixpkgs {
            inherit system;
            overlays = [self.overlays.default];
          };
        });
  in {
    overlays.default = final: prev: let
      jdk = prev."jdk${toString javaVersion}";
    in {
      gradle = prev.gradle.override {java = jdk;};
      kotlin = prev.kotlin.override {jre = jdk;};
    };

    devShells = forEachSupportedSystem ({pkgs}: {
      default = pkgs.mkShell {
        packages = with pkgs; [
          gcc
          gradle
          kotlin
          ncurses
          patchelf
          zlib
        ];
      };
    });
  };
}
