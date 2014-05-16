Include "binaryheaps.bb"

Graphics 800,600,16,2

BinID% = BinaryHeap_New%(BinaryHeap_SORT_BIGGEST)
BinID2% = BinID


BinaryHeap_Draw(BinID,0, 4)

SeedRnd MilliSecs()
While Not KeyHit(1)
	valor = Rand(1,500)
	If KeyDown(2) Then 
		time = MilliSecs()
		BinaryHeap_Add%(BinID,valor,valor)
		DebugLog "Tempo: "+(MilliSecs()-time)
	EndIf
	
	If KeyHit(3) Then 
		time = MilliSecs()
		DebugLog "Remove: "+BinaryHeap_Remove%(BinID)
		DebugLog "Tempo: "+(MilliSecs()-time)
	EndIf
	If KeyHit(4) Then
		valor% = Int(Input("mudar >"))
		BinaryHeap_Modify%(BinID, valor%,valor,666)
		DebugLog "Modify"
	EndIf
	If KeyHit(5) Then 
		BinID% = BinaryHeap_New%(BinaryHeap_SORT_BIGGEST)
		DebugLog "Add New"+BinID%
	EndIf
	
	If KeyHit(71) Then BinID = BinID + 1: DebugLog "Subiu: "+BinID%
	If KeyHit(75) Then BinID = BinID - 1: DebugLog "Desceu: "+BinID%
	
	BinaryHeap_Draw(BinID,0, 0)
Wend
