class Solution:
    def removeSubfolders(self, folder):
        folder = sorted(folder, key=lambda x: len(x.split("/")))
        result = []
        d = set()

        for f in folder:
            dirs = f.split("/")
            exist = False
            for i in range(1, len(dirs)):
                prefix = "/".join(dirs[0:i])
                if prefix in d:
                    exist = True
                    break

            if exist:
                continue
            else:
                d.add(f)
                result.append(f)

        return result
