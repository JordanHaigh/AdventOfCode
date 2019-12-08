using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Common {
    public class FileReader {
        public static List<string> ReadFile(string path) {
            if(!File.Exists(path)){
                throw new Exception("File path not found");
            }

            var lines = File.ReadAllLines(path);
            return new List<string>(lines);
        }

        private static List<string> ReadFileDelimited(string path, string delimiter) {
            if(!File.Exists(path)) {
                throw new Exception("File path not found");
            }

            string lines = File.ReadAllText(path);
            string[] brokenLines = lines.Split(delimiter);
            return new List<string>(brokenLines);
        }

        public static List<string> ReadFileCommaDelimited(string path) {
            return ReadFileDelimited(path, ",");
        }
    }
}
