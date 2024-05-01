# Irregular Columnar Transposition Cipher

Irregular Columnar Transposition është një formë e shifrimit të tekstit që perdor një metodë transpozicioni ku teksti (plaintext) vendoset në rreshta brenda një tabelë, e më pas lexohet në kolona në një rend të paracaktuar nga një çelës për të krijuar kështu tekstin e enkriptuar (ciphertext). Kjo metodë ndryshon nga Regular Columnar Transposition në mënyren se si trajtohen rreshtat dhe kolonat gjatë mbushjes dhe leximit të tabelës, ku hapësirat e zbrazëta për mbushur të gjithë matricën lihen bosh per dallim nga Regular Columnar Transposition ku mbushen me random letters.

Fillimisht bëhet zgjedhja e çelësit, ku mund të zgjedhet një fjalë ose një varg numrash. Çelësi do t'a përcaktojë rendin e leximit të kolonave. Shembull, nëse çelësi është "ORA", radhitja alfabetike e shkronjave të çelësit (AOR - 123) do të përdoret për të përcaktuar rendin e kolonave (kolona e parë është ajo që korrespondon me 'A', pastaj 'H', dhe 'P' në fund). Meqë e kemi fjalën ORA, çelësi ynë është **231**.
Pastaj teksti vendoset në rreshtat e tabelës, në rast se teksti nuk e mbush plotësisht tabelën atëherë hapësirat në tabelë mbeten bosh. Kolonat lexohen sipas radhës së paracaktuar nga çelësi.
Kolonat lexohen sipas radhës së paracaktuar nga çelësi. 

Në kodin tonë mundësia e zgjedhjës së çelësit është vetëm nga ana e programuesit, kurse teksti i cili do të enkriptohet do të merret direkt nga përdoruesi, përmes Scannerit. Dhe si rezultat i saj do të shfaqet teksi i enkriptuar në output, kurse për dekriptim i kemi dhënë tekstin e enkriptuar nga inputi i përdoruesit, në mënyrë që të vërtetohet saktësia e kodit.

Shembull, e kemi tekstin "Detyra në siguri" dhe çelësin "HACK":

```
3 1 2 4

D e t y
r a   n
ë   s i
g u r i

```
Teksti i koduar i "Detyra ne siguri" me çelësin "HACK" është "ea ut srDrëgynii". 

