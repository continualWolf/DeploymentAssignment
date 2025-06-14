package com.crs.model;

public final class settings {
      private static settings instance;
      public int MaximumFileSize;
      public String[] AllowedFileTypes;

      private settings(int maxFileSize, String[] allowedFileTypes) {
            this.MaximumFileSize = maxFileSize;
            this.AllowedFileTypes = allowedFileTypes;
      }

      public static settings getInstance(int maxFileSize, String[] allowedFileTypes) {
             if(instance == null) {
                   instance = new settings(maxFileSize, allowedFileTypes);
             }
              return instance;
      }
}