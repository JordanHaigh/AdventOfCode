using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Day1 {
    class FileReader {
        public static List<string> ReadFile(string path) {
            if(!File.Exists(path)){
                throw new Exception("File path not found");
            }

            var lines = File.ReadAllLines(path);
            return new List<string>(lines);

        }

    }
}
